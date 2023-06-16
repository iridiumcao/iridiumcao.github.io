# hanoi tower
def hanoi(n, a, b, c): # 以 b 为中转, 将 i 个盘子从 a 移动到 c
  if n == 1:
    print(a, '->', c) # 直接将 a 移动到 c
    return

  if n > 1:
    hanoi(n - 1, a, c, b) # 以 c 为中转, 将 i-1 个盘子从 a 移动到 b
    print(a, '->', c) # 直接将 a 移动到 c, 此时移动的就是最底下的那个盘子
    hanoi(n -1, b, a, c) # 以 a 为中转, 将 i-1 个盘子从 b 移动到 c

# sample
hanoi(3, 'A', 'B', 'C')