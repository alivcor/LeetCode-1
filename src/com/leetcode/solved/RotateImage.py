
def rotateMatrix(s):
    n = len(s)
    for i in range(0,n/2):
        for j in range(i,n-i-1):
            temp = s[i][j]
            s[i][j] = s[n-j-1][i]
            s[n-j-1][i] = s[n-i-1][n-j-1]
            s[n-i-1][n-j-1] = s[j][n-i-1]
            s[j][n-i-1] = temp


    return s;

