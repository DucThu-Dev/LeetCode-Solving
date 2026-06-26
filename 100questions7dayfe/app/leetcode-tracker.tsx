"use client";

import { useEffect, useMemo, useState } from "react";
import type { LeetCodeDayPlan } from "@/lib/leetcode-plan";

const DB_NAME = "leetcode-planning";
const DB_VERSION = 1;
const STORE_NAME = "practice";

type PracticeRecord = {
  key: string;
  practiced: boolean;
};

function openPracticeDb(): Promise<IDBDatabase> {
  return new Promise((resolve, reject) => {
    const request = window.indexedDB.open(DB_NAME, DB_VERSION);

    request.onupgradeneeded = () => {
      const db = request.result;
      if (!db.objectStoreNames.contains(STORE_NAME)) {
        db.createObjectStore(STORE_NAME, { keyPath: "key" });
      }
    };

    request.onsuccess = () => resolve(request.result);
    request.onerror = () => reject(request.error);
  });
}

async function getAllPracticeRecords(): Promise<Record<string, boolean>> {
  const db = await openPracticeDb();

  return new Promise((resolve, reject) => {
    const tx = db.transaction(STORE_NAME, "readonly");
    const store = tx.objectStore(STORE_NAME);
    const request = store.getAll();

    request.onsuccess = () => {
      const result = request.result as PracticeRecord[];
      const mapped = result.reduce<Record<string, boolean>>((acc, item) => {
        acc[item.key] = item.practiced;
        return acc;
      }, {});
      resolve(mapped);
    };
    request.onerror = () => reject(request.error);
    tx.oncomplete = () => db.close();
  });
}

async function savePracticeRecord(key: string, practiced: boolean): Promise<void> {
  const db = await openPracticeDb();

  return new Promise((resolve, reject) => {
    const tx = db.transaction(STORE_NAME, "readwrite");
    const store = tx.objectStore(STORE_NAME);
    store.put({ key, practiced });

    tx.oncomplete = () => {
      db.close();
      resolve();
    };
    tx.onerror = () => reject(tx.error);
  });
}

function getProblemKey(dayTitle: string, id: string): string {
  return `${dayTitle}::${id}`;
}

export default function LeetCodeTracker({ plans }: { plans: LeetCodeDayPlan[] }) {
  const [checked, setChecked] = useState<Record<string, boolean>>({});
  const [isReady, setIsReady] = useState(false);

  useEffect(() => {
    let isMounted = true;

    getAllPracticeRecords()
      .then((records) => {
        if (!isMounted) return;
        setChecked(records);
        setIsReady(true);
      })
      .catch(() => {
        if (!isMounted) return;
        setIsReady(true);
      });

    return () => {
      isMounted = false;
    };
  }, []);

  const totalCount = useMemo(
    () =>
      plans.reduce((sum, day) => {
        return sum + day.problems.length;
      }, 0),
    [plans],
  );

  const practicedCount = useMemo(() => {
    return Object.values(checked).filter(Boolean).length;
  }, [checked]);

  const onToggle = async (key: string, nextValue: boolean) => {
    setChecked((prev) => ({ ...prev, [key]: nextValue }));

    try {
      await savePracticeRecord(key, nextValue);
    } catch {
      // Keep UI responsive even if persistence fails.
    }
  };

  return (
    <main className="mx-auto flex w-full max-w-5xl flex-col gap-6 px-4 py-8 md:px-8">
      <header className="rounded-xl border border-zinc-200 bg-white p-5 shadow-sm">
        <h1 className="text-2xl font-bold text-zinc-900 md:text-3xl">
          LeetCode 7-Day Practice Tracker
        </h1>
        <p className="mt-2 text-zinc-600">
          Check each problem after practicing it. Your progress is saved in your browser.
        </p>
        <p className="mt-3 text-sm font-medium text-zinc-700">
          Progress: {practicedCount}/{totalCount} practiced
          {!isReady && " (loading saved progress...)"}
        </p>
      </header>

      {plans.map((day) => (
        <section
          key={day.dayTitle}
          className="rounded-xl border border-zinc-200 bg-white p-5 shadow-sm"
        >
          <h2 className="text-lg font-semibold text-zinc-900">{day.dayTitle}</h2>
          <ul className="mt-4 space-y-3">
            {day.problems.map((problem) => {
              const key = getProblemKey(day.dayTitle, problem.id);
              const isChecked = Boolean(checked[key]);

              return (
                <li
                  key={key}
                  className="flex items-start justify-between gap-4 rounded-lg border border-zinc-200 px-3 py-2"
                >
                  <label className="flex items-start gap-3">
                    <input
                      type="checkbox"
                      className="mt-1 h-4 w-4 cursor-pointer"
                      checked={isChecked}
                      onChange={(event) => onToggle(key, event.target.checked)}
                    />
                    <span className="text-sm text-zinc-800">
                      <span className="font-semibold">{problem.id}. </span>
                      {problem.title}
                      <span className="ml-2 rounded bg-zinc-100 px-2 py-0.5 text-xs text-zinc-600">
                        {problem.difficulty}
                      </span>
                      <span className="ml-2 rounded bg-blue-50 px-2 py-0.5 text-xs text-blue-700">
                        {problem.pattern}
                      </span>
                    </span>
                  </label>

                  <a
                    className="shrink-0 text-sm font-medium text-blue-600 hover:text-blue-800"
                    href={problem.url}
                    target="_blank"
                    rel="noreferrer"
                  >
                    Open
                  </a>
                </li>
              );
            })}
          </ul>
        </section>
      ))}
    </main>
  );
}
