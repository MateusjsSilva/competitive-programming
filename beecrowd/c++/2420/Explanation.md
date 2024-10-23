# Descrição do Problema
Após uma guerra de 50 anos, os países Tombólia do Oeste e Tombólia do Leste decidiram fazer um tratado de paz. Para terminar a disputa, eles precisam dividir o território de forma justa. O território é composto por várias seções de tamanhos distintos, dispostas em sequência, e eles querem encontrar um ponto de divisão que satisfaça a seguinte condição:

A soma das seções da esquerda até a seção k deve ser igual à soma das seções da direita a partir da seção k+1.
Sua tarefa é determinar a seção k que divide o território conforme essa condição.

### Exemplo:
Dado um conjunto de N seções de território, representadas por números inteiros:

- Seção 1: a1
- Seção 2: a2
- ...
- Seção N: aN

Encontre o ponto de divisão k tal que:

```
a1 + a2 + ... + ak = ak+1 + ak+2 + ... + aN
```

### Entrada
A primeira linha da entrada contém um inteiro N (1 ≤ N ≤ 10⁵) indicando o número de seções do território.
A segunda linha contém N inteiros a1, a2, ..., aN (1 ≤ ai ≤ 100), separados por espaço, que indicam os comprimentos de cada seção.

### Saída
O programa deve imprimir uma única linha contendo o índice da seção k onde deve acontecer a divisão (baseada em índice 1).

**Observação:** O problema garante que sempre haverá uma divisão que satisfaz a condição pedida.

## Abordagem para Solução

#### Passos para Resolver o Problema:
1. **Somar Todas as Seções:** Primeiramente, precisamos calcular a soma total de todas as seções.
2. **Cálculo Progressivo:** À medida que percorremos o array de seções, vamos acumulando a soma das seções à esquerda (inicialmente 0). Para cada posição k, a soma à direita pode ser obtida subtraindo a soma à esquerda da soma total.
3. **Verificar o Ponto de Divisão:** Quando a soma acumulada das seções à esquerda for igual à soma das seções à direita, encontramos o ponto k onde a divisão deve ocorrer.

## Código:
1. **Entrada:** Lemos o número de seções e o tamanho de cada uma delas.
2. **Cálculo da Soma Total:** Inicialmente, somamos todas as seções.
3. **Iteração para Encontrar o Ponto de Divisão:**
    - Para cada seção, removemos seu valor da soma total (para obter a soma das seções à direita).
    - Verificamos se a soma à esquerda é igual à soma à direita. Se sim, imprimimos o índice da seção k.

**Otimização:** O código faz uma única iteração sobre o array, resultando em uma complexidade linear O(N).