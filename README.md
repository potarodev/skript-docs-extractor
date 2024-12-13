# skript-docs-extractor

plugin that extracts syntax annotation data from all installed skript addons

includes a task to install popular addons & extract data from those, included in repo as well

(wip, usage does not work currently)

## usage

### as a plugin

- build with `./gradlew build`
- add as a plugin to your server
- run the command `/dump` as console or with permission `skdoc.dump`
- data will be available in `plugins/skript-docs-extractor/`

### standalone with run-task

- run `./gradlew extract`
- data will be available in `data/`