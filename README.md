# OpenRoadCode OS

OpenRoadCode OS is a Yocto Project distribution and image for supported
single-board computers.

The repository contains only OpenRoadCode metadata and reproducible build
descriptions. Poky and the hardware BSP layers are fetched at pinned revisions
by [kas](https://kas.readthedocs.io/).

## Supported targets

| Board | Yocto machine | kas configuration |
| --- | --- | --- |
| Raspberry Pi 4 (64-bit) | `raspberrypi4-64` | `kas/rpi4.yml` |
| Raspberry Pi 5 | `raspberrypi5` | `kas/rpi5.yml` |
| Libre Computer Renegade | `roc-rk3328-cc` | `kas/renegade.yml` |

All targets use the `openroadcode` distribution and build the
`openroadcode-image` image.

## Prerequisites

Install the host packages required by Yocto and install kas in an isolated
Python environment. For example:

```bash
python3 -m venv .venv
. .venv/bin/activate
python3 -m pip install kas
```

## Build

Run a build from the repository root. Use a separate build directory for each
machine:

```bash
KAS_BUILD_DIR=build-rpi4 kas build kas/rpi4.yml
KAS_BUILD_DIR=build-rpi5 kas build kas/rpi5.yml
KAS_BUILD_DIR=build-renegade kas build kas/renegade.yml
```

Downloaded sources and shared-state artifacts default to `downloads/` and
`sstate-cache/` at the repository root. Both are ignored by Git and shared
between the machine builds.

Images are deployed below:

```text
build-<machine>/tmp/deploy/images/<yocto-machine>/
```

## Repository contents

- `meta-openroadcode/` contains distribution policy, image recipes, package
  groups, and future OpenRoadCode recipes.
- `kas/common.yml` pins Poky and defines settings shared by all machines.
- The board-specific kas files pin and enable the required BSP layers.

Do not edit Poky or BSP layers for product changes. Put OpenRoadCode changes in
`meta-openroadcode`, using `.bbappend` files where upstream recipes need to be
extended.
