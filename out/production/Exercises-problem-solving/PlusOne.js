const toNumber = function (digits) {
    let number = 0;
    for (let i = 0; i < digits.length; i++) {
      number = number * 10 + digits[i];
    }
    return number;
  };
  const toDigits = function (number) {
    let digits = [];
    while (number > 0) {
      digits.push(number % 10);
      number = Math.floor(number / 10);
    }
    return digits.reverse();
    // reverse()
  };

const plusOne = function (digits) {
    const number = toNumber(digits)
    const newArray = toDigits(number+1)
    return newArray
};

plusOne([1, 2, 3]);




console.log(plusOne([1,2,3]));
