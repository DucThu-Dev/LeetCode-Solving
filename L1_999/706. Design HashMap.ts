class MyHashMap {
  ENTRIES_SIZE: number = 500

  private entries = new Array<Array<Array<number>>>(this.ENTRIES_SIZE);

  put(key: number, value: number): void {
    let keyIndex = this.hash(key);
    if (this.entries[keyIndex]) {
      let entryIndex = this.entries[keyIndex].findIndex(entry => entry[0] === key);
      if (entryIndex >= 0) this.entries[keyIndex][entryIndex][1] = value;
      else this.entries[keyIndex].push([key, value]);
    } else {
      this.entries[keyIndex] = new Array<Array<number>>(1).fill([key, value])
    }
  }

  get(key: number): number {
    let keyIndex = this.hash(key)
    if (this.entries[keyIndex]) {
      let entryIndex = this.entries[keyIndex].findIndex(entry => entry[0] === key);
      if (entryIndex >= 0) return this.entries[keyIndex][entryIndex][1]
    }
    return -1;
  }

  remove(key: number): void {
    let keyIndex = this.hash(key)
    if (this.entries[keyIndex]) {
      let entryIndex = this.entries[keyIndex].findIndex(entry => entry[0] === key);
      if (entryIndex >= 0) this.entries[keyIndex][entryIndex][1] = -1
    }
  }

  hash(key: number): number {
    return key % this.ENTRIES_SIZE
  }
}

/// Even easier
class MyHashMap2 {

  private entries = new Array<number>();

  put(key: number, value: number): void {
    this.entries[key] = value;
  }

  get(key: number): number {
    return this.entries[key] ?? -1
  }

  remove(key: number): void {
    delete this.entries[key]
  }
}