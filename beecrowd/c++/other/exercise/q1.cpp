#include <bits/stdc++.h>
using namespace std;

void dfs(int v, vector<vector<int>>& adj, vector<bool>& visited, vector<int>& component) 
{
    visited[v] = true;
    component.push_back(v);

    for (int u : adj[v]) {
        if (!visited[u]) {
            dfs(u, adj, visited, component);
        }
    }
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
    vector<vector<int>> components;

    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            vector<int> component;
            dfs(i, adj, visited, component);
            components.push_back(component);
        }
    }

    if (components.size() == 1) {
        cout << "O grafo é conexo." << endl;
    } else {
        cout << "O grafo não é conexo." << endl;
        for (int i = 0; i < components.size(); i++) {
            cout << "Componente " << i + 1 << ": ";
            for (int v : components[i]) {
                cout << v << " ";
            }
            cout << endl;
        }
    }

    return 0;
}