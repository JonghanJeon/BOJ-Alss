import sys
input = sys.stdin.readline
N = int(input())
li = []
for _ in range(N):
    li.append(input().strip())
li = list(set(li))
li.sort(key=lambda x: (len(x), x))

for item in li:
    print(item)