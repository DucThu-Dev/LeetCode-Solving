function uncommonFromSentences(s1: string, s2: string): string[] {
  const map = new Map<string, number>()

  const split1: string[] = s1.split(" ");
  const split2: string[] = s2.split(" ");

  ([...split1, ...split2]).forEach(item => {
    accessMap(item)
  });

  function accessMap(word: string) {
    if (map.has(word)) {
      map.set(word, map.get(word)! + 1)
    } else {
      map.set(word, 1)
    }
  }

  const mapKeys = Array.from(map.keys())
  const mapValues = Array.from(map.values())

  const result: string[] = [];
  for (let i = 0; i < map.size; i++) {
    if (mapValues[i] === 1) {
      result.push(mapKeys[i])
    }
  }

  return result;
};

function improvedUncommonFromSentences(s1: string, s2: string): string[] {
  const words = [...s1.split(" "), ...s2.split(" ")]
  const map = new Map<string, number>()
  for (const word of words) {
    map.set(word, 1 + (map.get(word) ?? 0))
  }

  return Array.from(map).reduce((result, [key, value]) => {
    if (value === 1) {
      result.push(key)
    }
    return result
  }, []);
}