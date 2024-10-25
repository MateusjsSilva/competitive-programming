#include <bits/stdc++.h>
using namespace std;

bool isBipartite(int start, vector<vector<int>>& adj, vector<int>& colors) 
{
    queue<int> q;
    q.push(start);
    colors[start] = 1;

    while (!q.empty()) {
        int v = q.front();
        q.pop();

        for (int u : adj[v]) {
            if (colors[u] == 0) {
                colors[u] = -colors[v];
                q.push(u);
            } else if (colors[u] == colors[v]) {
                return false;
            }
        }
    }
    return true;
}

int main() 
{
    int n, m;
    cin >> n >> m;

    vector<vector<int>> adj(n + 1);
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        if (u >= 1 && u <= n && v >= 1 && v <= n) {
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
    }

    vector<int> colors(n + 1, 0);
    bool isGraphBipartite = true;

    for (int i = 1; i <= n; i++) {
        if (colors[i] == 0) {
            if (!isBipartite(i, adj, colors)) {
                isGraphBipartite = false;
                break;
            }
        }
    }

    if (isGraphBipartite) {
        cout << "O grafo é bipartido." << endl;
    } else {
        cout << "O grafo não é bipartido." << endl;
    }

    return 0;
}