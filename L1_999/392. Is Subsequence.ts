function isSubsequence(s: string, t: string): boolean {
  const nt = t.length, ns = s.length;
  if (ns === 0) return true;
  if (ns === nt) return s === t;
  if (ns > nt) return false;
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