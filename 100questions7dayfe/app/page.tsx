import { readFile } from "node:fs/promises";
import { join } from "node:path";
import LeetCodeTracker from "./leetcode-tracker";
import { parseLeetCodePlan } from "@/lib/leetcode-plan";

export default async function Home() {
  const markdownPath = join(process.cwd(), "content", "leetcode_7day_plan.md");
  const markdownContent = await readFile(markdownPath, "utf8");
  const plans = parseLeetCodePlan(markdownContent);

  return (
    <div className="min-h-screen bg-zinc-50">
      <LeetCodeTracker plans={plans} />
    </div>
  );
}
