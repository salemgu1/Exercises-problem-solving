const lengthOfLastWord = function (s) {
  const wordArray = s.trim().split(/(\s+)/);
  console.log(wordArray);
  const last = wordArray.length - 1;
  if (wordArray[last] === "") {
    return 0;
  } else {
    return wordArray[last].length;
  }
};
console.log(lengthOfLastWord("   fly me   to   the moon  "));
