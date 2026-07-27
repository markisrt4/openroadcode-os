SUMMARY = "OpenRoadCode development image"
DESCRIPTION = "Development image for OpenRoadCode automotive systems"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += " \
    ssh-server-openssh \
    debug-tweaks \
"

IMAGE_INSTALL += " \
    packagegroup-openroadcode-base \
"
