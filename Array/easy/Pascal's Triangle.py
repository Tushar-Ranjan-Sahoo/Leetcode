class solution:
    def gennerate(self,numRow:int) -> List[List[int]]:
        pascal = [[1]*i for i in range(1,numRow)]
        for i in range(2,numRow):
            for j in range(1,i):
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
        return pascal