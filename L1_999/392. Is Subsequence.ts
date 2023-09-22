function isSubsequence(s: string, t: string): boolean {
  if (s.length === 0) return true;
  if (s.length === t.length) return s === t;
  const nt = t.length, ns = s.length;
  let pt = 0;
  let ps = 0;
  while (pt < nt) {
    if (s[ps] === t[pt]) {
      if (ps >= ns - 1) return true;
      ps++;
    }
    pt++;
  }

  return false;
};