function makeFancyString(s: string): string {
  const n = s.length;
  if (!n) return s;

  const output = [s[0]];
  let current = s[0];
  let count = 1;

  for (let i = 1; i < n; i++) {
    if (s[i] === current) {
      count++;
      if (count <= 2) {
        output.push(current);
      }
    } else {
      current = s[i];
      output.push(current);
      count = 1;
    }
  }

  return output.join("");
}
