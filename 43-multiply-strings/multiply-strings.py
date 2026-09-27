class Solution:
    def multiply(self, num1, num2):
        if num1 == "0" or num2 == "0":
            return "0"

        result = [0] * (len(num1) + len(num2))

        for i in range(len(num1) - 1, -1, -1):
            for j in range(len(num2) - 1, -1, -1):

                mul = int(num1[i]) * int(num2[j])

                pos1 = i + j
                pos2 = i + j+1

                total = mul + result[pos2]

                result[pos2] = total % 10
                result[pos1] += total // 10

        # Remove leading zeros
        while result[0] == 0:
            result.pop(0)

        return ''.join(map(str, result))