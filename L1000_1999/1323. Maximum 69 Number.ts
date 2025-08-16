function maximum69Number(num: number): number {
  let didChange = false;
  return Number(
    num
      .toString()
      .split("")
      .map((value) => {
        if (didChange) return value;
        if (value === "6") didChange = true;
        return "9";
      })
      .join("")
  );
}
