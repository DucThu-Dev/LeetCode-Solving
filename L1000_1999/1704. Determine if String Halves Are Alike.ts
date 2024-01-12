function halvesAreAlike(s: string): boolean {
  const vowels: string[] = ['u', 'a', 'e', 'o', 'i']
  const n = s.length / 2 >> 0
  let half1 = s.substring(0, n)
  let half2 = s.substring(n)
  let count1 = 0
  let count2 = 0

  for (let i = 0; i < n; i++) {
    if (vowels.indexOf(half1[i].toLowerCase()) > -1) count1++
    if (vowels.indexOf(half2[i].toLowerCase()) > -1) count2++
  }
  return count1 === count2
};