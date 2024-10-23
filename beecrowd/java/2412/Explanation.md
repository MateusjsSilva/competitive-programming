# Descrição do Problema

Tarzan precisa manter a ordem na floresta e, para isso, ele viaja entre as árvores utilizando cipós. Após uma tempestade, restaram apenas 
𝑁 árvores, e ele quer saber se consegue viajar entre todas elas usando os cipós. Ele só pode viajar entre duas árvores se a distância entre elas for menor ou igual ao alcance 
𝐷 dos cipós.

O objetivo é verificar se Tarzan consegue alcançar todas as árvores a partir de qualquer árvore, possivelmente passando por outras árvores no caminho.

## Entradas:
- **N**: Número de árvores restantes (2 ≤ N ≤ 1000).
- **D**: Alcance dos cipós em metros (1 ≤ D ≤ 5000).
- **(X<sub>i</sub>, Y<sub>i</sub>)**: Coordenadas de cada árvore no plano (0 ≤ X<sub>i</sub>, Y<sub>i</sub> ≤ 5000).

## Saída:
- "S": Tarzan consegue viajar entre todas as árvores.
- "N": Tarzan não consegue viajar entre todas as árvores.

# Resolução

## 1. Modelagem do Problema como Grafo
- Cada árvore é um nó (vértice) em um grafo.
- Existe uma aresta entre dois nós (árvores) i e j se a distância entre eles for menor ou igual a D.
- Distância Euclidiana entre duas árvores com coordenadas (X<sub>i</sub>, Y<sub>i</sub>) e (X<sub>j</sub>, Y<sub>j</sub>):
    - d(i,j) = √((X<sub>i</sub> - X<sub>j</sub>)² + (Y<sub>i</sub> - Y<sub>j</sub>)²)
- Em vez de calcular a raiz quadrada, comparamos os quadrados das distâncias:
    - d(i,j)² ≤ D²

## 2. Objetivo
- Verificar se o grafo formado é conexo, ou seja, se é possível alcançar todas as árvores partindo de qualquer árvore.
- Para isso, utilizamos Busca em Profundidade (DFS) para explorar o grafo.

# Implementação

## 1. Entrada dos Dados
- Ler o número de árvores N e o alcance D.
- Ler as coordenadas (X<sub>i</sub>, Y<sub>i</sub>) de cada árvore.

## 2. Construção do Grafo
- Criar uma lista de adjacência que conecte as árvores com distância ≤ D.
- Para cada par de árvores i e j, calcular a distância e adicionar uma aresta entre elas se a distância for válida.

## 3. Busca em Profundidade (DFS)
- Utilizar DFS para verificar se todas as árvores podem ser visitadas a partir de uma árvore inicial.
- Marcar as árvores visitadas em um array booleano `visitado[]`.

## 4. Verificar Conectividade
- Após a DFS, verificar se todas as árvores foram visitadas.
- Se todas foram visitadas, o grafo é conexo e a resposta é "S". Caso contrário, a resposta é "N".