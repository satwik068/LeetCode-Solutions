from collections import deque

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        c = 0
        seen = set()

        for i in range(len(isConnected)):

            if i not in seen:
                c += 1

                seen.add(i)
                q = deque([i])

                while q:
                    n = q.popleft()

                    for j in range(len(isConnected)):
                        if j not in seen and isConnected[n][j]:
                            seen.add(j)
                            q.append(j)

        return c