class RandomizedSet {
  constructor() {

  }

  map: Map<number, number> = new Map()

  insert(val: number): boolean {
    if (this.map.has(val)) return false
    this.map.set(val, 0)
    return true;
  }

  remove(val: number): boolean {
    return this.map.delete(val)
  }

  getRandom(): number {
    let index = (Math.random() * this.map.size) >> 0
    return Array.from(this.map.keys())[index]
  }
}

/**
* Your RandomizedSet object will be instantiated and called as such:
* var obj = new RandomizedSet()
* var param_1 = obj.insert(val)
* var param_2 = obj.remove(val)
* var param_3 = obj.getRandom()
*/