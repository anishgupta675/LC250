class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        fact, numbers = 1, []
        for i in range(1, n):
            fact *= i
            numbers.append(i)
        numbers.append(n)
        ans = ""
        k -= 1
        while True:
            ans += str(numbers[k // fact])
            numbers.pop(k // fact)
            if not len(numbers):
                break
            k %= fact
            fact //= len(numbers)
        return ans
