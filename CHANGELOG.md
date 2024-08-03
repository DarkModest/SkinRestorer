# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [2.0.2] - 2024-08-04
### Added
- Backported to minecraft 1.20-1.20.2
- [Forge] Added support for Forge
### Changed
- Changed minimum java version to 17 for minecraft 1.20-1.20.4

## [2.0.1] - 2024-07-16
### Added
- Added Traditional Chinese translation ([#24](https://github.com/Suiranoil/SkinRestorer/pull/24)) - *yichifauzi*, *notlin4*
### Fixed
- Fixed concurrent modification exception

## [2.0.0] - 2024-07-03
### Added
- Added support for NeoForge
- Added support for singleplayer
- Added ely.by skin provider
- Added `/skin refresh` command to get up-to-date skin
- Added `/skin reset` command to remove skin data
- Added proper support for secure servers
- Added support for permissions api
- Added translations
### Changed
- Changed to save skin data per world
### Fixed
- Fixed entity flickering on skin reload
- Fixed player being left in invalid state on skin reload if on death screen

## [1.2.6] - 2024-06-25
### Added
- Added support for command blocks
### Changed
- Changed to better skin refresh logic
### Fixed
- Fixed no permission level for /skin clear targets
- Fixed loading world screen on skin change

## [1.2.4] - 2023-09-30
### Fixed
- Fixed player stops riding entity with skin change
- Fixed armor and hand items not displaying with skin change

## [1.2.3] - 2023-06-10
### Changed
- Updated to 1.20-1.20.1

## [1.2.2] - 2022-12-21
### Changed
- Updated to 1.19.3

## [1.2.1] - 2022-11-24
### Fixed
- Fixed incorrect filepath resolvement on linux systems

## [1.2.0] - 2022-11-18
### Added
- Added support for fake players ([#4](https://github.com/Suiranoil/SkinRestorer/pull/4)) - *CaveNightingale*
### Changed
- Allow player to apply their skin changes immediately ([#4](https://github.com/Suiranoil/SkinRestorer/pull/4)) - _CaveNightingale_

## [1.0.4] - 2021-08-28
### Fixed
- Fixed "invalid player data" exception
