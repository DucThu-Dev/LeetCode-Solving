function evalRPN(tokens: string[]): number {
  const stack: number[] = []
  while (tokens.length) {
    const t: string = tokens.shift()!
    if (['+', '-', '*', '/'].includes(t)) {
      const n = stack.length
      stack.push(operate(stack.pop()!, stack.pop()!, t))
    } else {
      stack.push(Number.parseInt(t))
    }
  }

  return stack[0];

  function operate(v2: number, v1: number, operator: string) {
    switch (operator) {
      case '+':
        return v1 + v2;
      case '-':
        return v1 - v2;
      case '*':
        return v1 * v2;
      case '/':
        return v1 / v2 >> 0;
      default:
        throw new Error("Should not reach this");

    }
  }
};