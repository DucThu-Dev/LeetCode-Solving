function isValid(word: string): boolean {
  if (word.length < 3) return false;

  const vowels = ["u", "a", "e", "o", "i", "U", "A", "E", "O", "I"].map(
    (char) => char.charCodeAt(0)
  );

  let haveAtLeast1Vowel = false;
  let haveAtLeast1Consonant = false;

  for (let i = 0; i < word.length; i++) {
    const isNumberOrLetter = charIsNumberOrLetter(word[i]);
    if (!isNumberOrLetter) return false;
    if (charIsNumber(word[i])) continue;
    if (haveAtLeast1Consonant && haveAtLeast1Vowel) continue;
    const vowel = isVowel(word[i]);
    if (!haveAtLeast1Consonant) {
      haveAtLeast1Consonant = !vowel;
    }
    if (!haveAtLeast1Vowel) {
      haveAtLeast1Vowel = vowel;
    }
  }

  return haveAtLeast1Consonant && haveAtLeast1Vowel;

  function charIsNumber(char: string): boolean {
    const code = char.charCodeAt(0);
    if (code >= "0".charCodeAt(0) && code <= "9".charCodeAt(0)) return true;
    return false;
  }

  function charIsNumberOrLetter(char: string): boolean {
    const code = char.charCodeAt(0);
    if (code >= "0".charCodeAt(0) && code <= "9".charCodeAt(0)) return true;
    if (code >= "A".charCodeAt(0) && code <= "Z".charCodeAt(0)) return true;
    if (code >= "a".charCodeAt(0) && code <= "z".charCodeAt(0)) return true;
    return false;
  }

  function isVowel(char: string) {
    return vowels.find((value) => value === char.charCodeAt(0)) != null;
  }
}
