function countAndSay(n: number): string {
  if (n === 1) return "1";

  const prevVal = countAndSay(n - 1);
  let returnString = "";

  let count = 1;

  for (let i = 0; i < prevVal.length; i++) {
    if (
      i === prevVal.length - 1 ||
      prevVal.charAt(i) !== prevVal.charAt(i + 1)
    ) {
      returnString += count + prevVal.charAt(i);
      count = 1;
    } else count++;
  }

  return returnString;
}

console.log(countAndSay(4));
