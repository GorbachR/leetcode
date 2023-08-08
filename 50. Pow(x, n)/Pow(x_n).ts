function myPow(x: number, n: number): number {
  if (n === 0) return 1;

  const temp = myPow(x, (n / 2) | 0);

  if (n % 2 === 0) {
    return temp * temp;
  } else if (n < 0) return (temp * temp) / x;
  else return x * temp * temp;
}

console.log(myPow(2, 10));
