function closeStrings(word1: string, word2: string): boolean {
  if (word1.length != word2.length) return false

  const n = word1.length;

  const counter1 = new Array(26).fill(0)
  const counter2 = new Array(26).fill(0)

  for (let i = 0; i < n; i++) {
    let index1 = word1.charCodeAt(i) - 97
    counter1[index1]++

    let index2 = word2.charCodeAt(i) - 97
    counter2[index2]++
  }

  const unmatch1: number[] = []
  const unmatch2: number[] = []

  for (let i = 0; i < 26; i++) {
    let value1 = counter1[i]
    let value2 = counter2[i]
    if (value1 !== value2) {
      if (!value1 || !value2) return false
      unmatch1.push(counter1[i])
      unmatch2.push(counter2[i])
    }
  }

  unmatch1.sort((a, b) => a - b)
  unmatch2.sort((a, b) => a - b)

  for (let i = 0; i < unmatch1.length; i++) {
    if (unmatch1[i] !== unmatch2[i]) return false
  }

  return true
};