class MountainArray {
  array = []

  get(index: number): number { return this.array[index] }

  length(): number { return this.array.length }
}

function findInMountainArray(target: number, mountainArr: MountainArray) {
  if (mountainArr.length() < 3) return -1;
  let left = 0, right = mountainArr.length() - 1
  let topIndex = -1;
  while (left < right) {
    let middle = left + (right - left) / 2 >> 0
    let valueLeft = middle - 1 >= 0 ? mountainArr.get(middle - 1) : -1
    let value = mountainArr.get(middle)
    let valueRight = middle + 1 >= mountainArr.length() ? Number.MAX_SAFE_INTEGER : mountainArr.get(middle + 1)
    if (valueLeft < value && value > valueRight) {
      topIndex = middle
      break;
    }
    if (valueLeft < value) {
      left = middle + 1
    } else {
      right = middle - 1
    }

    if (left === right) topIndex = left
  }

  left = 0
  right = topIndex
  while (left < right) {
    let middle = left + (right - left) / 2 >> 0
    let value = mountainArr.get(middle)
    if (value === target) return middle

    if (value < target) left = middle + 1
    else right = middle - 1
  }
  if (mountainArr.get(left) === target) return left;

  left = topIndex
  right = mountainArr.length() - 1
  while (left < right) {
    let middle = left + (right - left) / 2 >> 0
    let value = mountainArr.get(middle)
    if (value === target) return middle

    if (value > target) left = middle + 1
    else right = middle - 1
  }
  if (mountainArr.get(left) === target) return left;

  return -1
};