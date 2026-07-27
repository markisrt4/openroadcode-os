SUMMARY = "OpenRoadCode base platform packages"
DESCRIPTION = "Common runtime packages for all OpenRoadCode platforms"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    bluez5 \
    bluez5-testtools \
    util-linux-rfkill \
    iproute2 \
    iputils \
    procps \
"
