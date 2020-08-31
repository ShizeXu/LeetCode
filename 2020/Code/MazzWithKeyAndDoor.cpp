#include<iostream>
#include<vector>
#include<unordered_map>
#include<queue>
using namespace std;

class MazzWithKeyAndDoor {
    struct Position {
        int x;
        int y;
        int key;
        Position(int i, int j, int k) : x(i), y(j), key(k) {};
        bool operator==(const Position& p) const
        {
            return (this->x == p.x && this->y == p.y && this->key == p.key);
        }
    };

    class MyHash {
    public:
        size_t operator()(const Position& p) const
        {
            return (std::hash<int>{}(p.x) ^ std::hash<int>{}(p.y) ^ std::hash<int>{}(p.key));
        }
    };

    void BFS(int n, int m, const Position& p, const vector<vector<char>>& mazz, queue<Position>& q, unordered_map<Position, int, MyHash>& map)
    {
        vector<vector<int>> steps = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
        int stepCnt = map[p] + 1;
        for (vector<int> step : steps)
        {
            int i = p.x + step[0];
            int j = p.y + step[1];
            if (i < 0 || i >= n || j < 0 || j >= m || mazz[i][j] == '#') continue;

            int k = p.key;

            // Handle key
            if (mazz[i][j] >= 'A' && mazz[i][j] <= 'Z')
                k |= (1 << mazz[i][j] - 'A');

            // Handle door
            else if (mazz[i][j] >= 'a' && mazz[i][j] <= 'z')
            {
                if ((k & (1 << (mazz[i][j] - 'a'))) == 0)
                    continue;
            }

            // Check visited
            Position newP(i, j, k);
            if (map.find(newP) != map.end())
                continue;

            // Should visit next
            map[newP] = stepCnt;
            q.push(Position(i, j, k));
        }
    }

    int CountMinStep(vector<vector<char>>& mazz)
    {
        unordered_map<Position, int, MyHash> map;
        int n = mazz.size();
        int m = mazz[0].size();

        // Find start
        int startI = -1;
        int startJ = -1;
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < m; ++j)
            {
                if (mazz[i][j] == '0')
                {
                    startI = i;
                    startJ = j;
                    break;
                }
            }

            if (startI >= 0) break;
        }

        // BFS
        queue<Position> q;
        Position startP(startI, startJ, 0);
        q.push(Position(startI, startJ, 0));
        map[startP] = 0;
        while (!q.empty())
        {
            Position p = q.front();
            q.pop();
            
            if (mazz[p.x][p.y] == '1')
                return map[p];
            int res = -1;
            BFS(n, m, p, mazz, q, map);
        }

        return -1;
    }

public:
    void RunTest()
    {
        vector<vector<char>> mazz = {
            {'#','#','#','#','#',},
            {'#','0','.','.','B',},
            {'.','.','#','a','#',},
            {'#','.','#','a','#',},
            {'#','A','#','b','1',},
            {'#','#','#','#','#',},
        };

        cout << CountMinStep(mazz) << endl;
    }
};