#include <bits/stdc++.h>
using namespace std;

bool dfsCycleCheck(int v, int parent, vector<vector<int>>& adj, vector<bool>& visited, int& edgeCount, vector<int>& component) 
{
    visited[v] = true;
    component.push_back(v);

    bool hasCycle = false;
    for (int u : adj[v]) {
        edgeCount++;
        if (!visited[u]) {
            if (dfsCycleCheck(u, v, adj, visited, edgeCount, component)) {
                hasCycle = true;
            }
        } else if (u != parent) {
            hasCycle = true;
        }
    }
    return hasCycle;
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
    bool foundCycle = false;

    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            vector<int> component;
            int edgeCount = 0;
            if (dfsCycleCheck(i, -1, adj, visited, edgeCount, component)) {
                foundCycle = true;
                cout << "Componente com ciclo encontrado:" << endl;
                cout << "Nós do componente: ";
                for (int v : component) cout << v << " ";
                cout << endl;
                cout << "Número de arestas: " << edgeCount / 2 << endl;
                cout << "Número de nós: " << component.size() << endl;
            }
            components.push_back(component);
        }
    }

    if (!foundCycle) {
        cout << "O grafo não possui ciclos." << endl;
    }

    return 0;
}