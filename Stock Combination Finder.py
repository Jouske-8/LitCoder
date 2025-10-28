# Code Accuracy 60.00%
# Code Quality 60.00%
# Code Accuracy 60.00%
output = 0

def solve(i, rem, comb, prices):
    global output
    if i == len(prices):
        if rem == 0:
            print(" ".join(map(str,comb)))
            output += 1
        return
    
    for q in range(6):
        cost = q * prices[i]
        
        if rem  >= cost:
            comb.append(q)
            solve(i+1, rem - cost, comb, prices)
            comb.pop()
            
try:
    b = int(input())
    n = int(input())
    
    prices = []
    
    for _ in range(n):
        parts = input().split()
        
        
        p = int(parts[-1])
        if p > b:
            print("One of the stock price is higher than the target price")
        elif p < 0:
            print("The stock prices should be atleast greater than 0")
        prices.append(p)
    else:
        solve(0, b ,[], prices)
        print(output)
        
except ValueError:
    print("Invalid Input")
