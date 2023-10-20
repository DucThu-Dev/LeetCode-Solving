function backspaceCompare(s: string, t: string): boolean {
  let charS: string | null = null;
  let charT: string | null = null;

  let backSpaceS = 0
  let backSpaceT = 0

  let xS = s.length - 1
  let xT = t.length - 1

  while (true) {
    while (xS >= 0) {
      let char = s[xS];
      if (char === '#') {
        backSpaceS++;
      } else {
        if (backSpaceS > 0) {
          backSpaceS--;
        } else {
          charS = char;
          xS--;
          break;
        }
      }

      xS--;
    }

    while (xT >= 0) {
      let char = t[xT];
      if (char === '#') {
        backSpaceT++;
      } else {
        if (backSpaceT > 0) {
          backSpaceT--;
        } else {
          charT = char;
          xT--;
          break;
        }
      }

      xT--;
    }

    if (charT === null && charS === null) {
      return true;
    }
    if (charT !== charS) {
      return false;
    }
    charT = null;
    charS = null;
  }
};