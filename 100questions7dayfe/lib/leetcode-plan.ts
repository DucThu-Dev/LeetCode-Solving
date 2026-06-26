export type LeetCodeProblem = {
  id: string;
  title: string;
  difficulty: string;
  pattern: string;
  url: string;
};

export type LeetCodeDayPlan = {
  dayTitle: string;
  problems: LeetCodeProblem[];
};

const dayHeaderRegex = /^##\s+(Day\s+\d+\s+—\s+.+)$/;
const tableRowRegex =
  /^\|\s*(\d+)\s*\|\s*(.+?)\s*\|\s*(Easy|Medium|Hard)\s*\|\s*(.+?)\s*\|\s*\[.*?\]\((https:\/\/leetcode\.com\/problems\/[^)]+)\)\s*\|$/;

export function parseLeetCodePlan(markdown: string): LeetCodeDayPlan[] {
  const lines = markdown.split("\n");
  const plans: LeetCodeDayPlan[] = [];

  let currentDay: LeetCodeDayPlan | null = null;

  for (const line of lines) {
    const dayMatch = line.match(dayHeaderRegex);
    if (dayMatch) {
      if (currentDay) {
        plans.push(currentDay);
      }

      currentDay = {
        dayTitle: dayMatch[1],
        problems: [],
      };
      continue;
    }

    if (!currentDay) {
      continue;
    }

    const rowMatch = line.match(tableRowRegex);
    if (!rowMatch) {
      continue;
    }

    const [, id, title, difficulty, pattern, url] = rowMatch;
    currentDay.problems.push({
      id,
      title,
      difficulty,
      pattern,
      url,
    });
  }

  if (currentDay) {
    plans.push(currentDay);
  }

  return plans;
}
