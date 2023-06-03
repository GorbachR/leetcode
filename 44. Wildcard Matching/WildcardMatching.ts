function isMatch(s: string, p: string): boolean {
  let stringPos = 0;
  let patternPos = 0;
  let starPos = -1;
  let match = 0;

  while (stringPos < s.length) {
    if (
      (patternPos < p.length && s.charAt(stringPos) === p.charAt(patternPos)) ||
      p.charAt(patternPos) === "?"
    ) {
      stringPos++;
      patternPos++;
    } else if (patternPos < p.length && p.charAt(patternPos) === "*") {
      starPos = patternPos;
      match = stringPos;
      patternPos++;
    } else if (starPos !== -1) {
      patternPos = starPos + 1;
      match++;
      stringPos = match;
    } else return false;
  }

  while (patternPos < p.length && p.charAt(patternPos) === "*") patternPos++;

  return p.length === patternPos;
}

console.log(isMatch("aa", "*"));
console.log(isMatch("adceb", "*a*b"));
console.log(isMatch("acdcb", "a*c?b"));
