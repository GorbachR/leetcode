function groupAnagrams(strs: string[]): string[][] {
  const anagrams: string[][] = [];

  const map = new Map<string, string[]>();

  for (let i = 0; i < strs.length; i++) {
    const sortedStr = strs[i].split("").sort().join();
    if (map.has(sortedStr)) map.get(sortedStr)?.push(strs[i]);
    else map.set(sortedStr, [strs[i]]);
  }

  for (const val of map.values()) anagrams.push(val);

  return anagrams;
}

console.log(groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]));
console.log(groupAnagrams(["", ""]));
