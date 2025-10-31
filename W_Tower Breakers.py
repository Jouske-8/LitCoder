# Litcoder Score : 92.50
# Accuracy Score : 100.00
# Quality Score : 85.00

def tower_breakers(n, m):
    if m == 1:
        return 1
    elif m % 2 == 0:
        return 2
    else:
        return 1
        
n, m = map(int, input().split())
print(tower_breakers(n ,m))
                                       
