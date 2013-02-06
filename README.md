BungeeTools
==========

Tools für BungeeCord

Downloads:

[Letzter Erfolgreicher Build](http://ci.skymine.de/job/BungeeTools/lastSuccessfulBuild/)

[Letzter Release Build](http://ci.skymine.de/job/BungeeTools/Release/)


Config
==========
```
server: Karion
servers:
  - 'null'
  - 'null'
  - '399@#@&a&lKarion@#@&6Freebuild/PvP Server.'
  - 'null'
  - '398@#@&a&lInsomnia@#@&6Spiele/Event und Parkour Server.'
  - 'null'
  - '54@#@&a&lAlassra@#@&6SkyBlock und Kreativ Server.'
  - 'null'
  - 'null'
```

Permissions
==========
```
- bungeetools.mute
- bungeetools.jail
- bungeetools.send
- bungeetools.kick
- bungeetools.ban
```
Benutzung
==========
```
/servers - Öffnet ein Menü zum Wechseln des Servers
/gban <player> (-s/-a) {reason} - Bann von allen Servern (Ultrabans)
/gkick <player / *> (-s/-a) {reason} - Kick von allen Servern (Ultrabans)
/send <player> [Server] - Spieler auf anderen Server verschieben
/gjail <player> (time) m j:(Jail name) c:(Cell name) r:\"(Reason)\" - Spieler ins Gefängniss (Jail)
/gmute <player> [datediff] - Spieler auf allen Servern Muten (Essentials)
```
