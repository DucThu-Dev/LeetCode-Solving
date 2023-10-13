function reverse(x: number): number {
  let multiply = x > 0 ? 1 : -1
  let reverse = x.toString().split('').reverse().join('')
  let result = Number.parseInt(reverse) * multiply
  return is32Bit(result) ? result : 0
};

function is32Bit(num: number): boolean {
  return (num | 0) === num;
}