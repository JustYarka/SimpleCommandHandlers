# SimpleCommandHandlers
Nukkit плагин. Это API, которое позволяет регистрировать лямбда-обработчик для каждой команды, а так же заменять обработчик для уже зарегистрированной команды на ваш

## Пример кода
```java
SimpleCommandHandler.getInstance().setPluginCommandHandler(this, "abc", (sender, args) -> {
            getLogger().error("PLUGIN OK");
            return false;
});

SimpleCommandHandler.getInstance().registerNewCommand("test", (sender, args) -> {
            getLogger().error("OK");
            return false;
});
```
