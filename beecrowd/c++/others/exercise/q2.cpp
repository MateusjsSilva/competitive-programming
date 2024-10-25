#include <bits/stdc++.h>

using namespace std;

bool dfs(int v, int parent, vector<vector<int>>& adj, vector<bool>& visited) 
{
    visited[v] = true;

    for (int u : adj[v]) {
        if (!visited[u]) {
            if (dfs(u, v, adj, visited)) {
                return true;
            }
        } else if (u != parent) {
            return true;
        }
    }
    return false;
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

    vector<bool> visited(n + 1, false);
    bool hasCycle = false;

    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            if (dfs(i, -1, adj, visited)) {
                hasCycle = true;
                break;
            }
        }
    }

    if (hasCycle) {
        cout << "Possui ciclo." << endl;
    } else {
        cout << "Não possui ciclo." << endl;
    }

    return 0;
}