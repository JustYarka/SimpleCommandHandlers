# SimpleCommandHandlers
Nukkit плагин. Это API, которое позволяет регистрировать лямбда-обработчик для каждой команды, а так же заменять обработчик для уже зарегистрированной команды на ваш

## Изменение обработчика для уже существующей команды (В примере плагин заменяет обработчик для своей же команды)
```java
SimpleCommandHandler.getInstance().setPluginCommandHandler(this, "abc", (sender, args) -> {
            getLogger().error("PLUGIN OK");
            return false;
});
```
## Регистрация команды
```java
SimpleCommandHandler.getInstance().registerNewCommand("test", (sender, args) -> {
            getLogger().error("OK");
            return false;
});
```
