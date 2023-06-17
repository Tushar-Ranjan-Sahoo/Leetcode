class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        maxnum = 0

        for i in range(len(number)):
            if number[i] == digit:
                newnum = int(number[:i] + number[i + 1:])
                maxnum = max(maxnum, newnum)
        return str(maxnum)