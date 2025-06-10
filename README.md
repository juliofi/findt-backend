
## findt-backend


#### Retorna uma pessoa pelo cpf

```
  POST https://findt-backend.onrender.com/pessoas/buscar/cpf
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cpf`      | `string` | post de json com key cpf  |

### Exemplo json

```json
{
  "cpf": "00000033333"
}
```

#### Retorna uma pessoa pelo nome

```
  POST https://findt-backend.onrender.com/pessoas/buscar/nome
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nomeCompleto`      | `string` | post de json com key nomeCompleto |

### Exemplo json

```json
{
  "nomeCompleto": "Gabriel"
}
```


## FAQ

#### Posso fazer buscas sem saber o nome completo?

Sim. Na busca pelo nome, a API busca por substrings, então se o nome não estiver totalmente completo, mas que filtre o suficiente, vai aparecer a busca desejada nos resultados.

#### Não sei o sobrenome de quem quero buscar, consigo encontrar?

Provavelmente não, a API retorna apenas os 20 primeiros resultados.
