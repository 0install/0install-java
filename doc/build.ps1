$ErrorActionPreference = "Stop"
pushd $(Split-Path -Path $MyInvocation.MyCommand.Definition -Parent)

if (!(Get-Command 0install -ErrorAction SilentlyContinue)) { # Ensure 0install is in PATH
    echo "Downloading 0install"
    mkdir -Force "$env:TEMP\zero-install" | Out-Null
    Invoke-WebRequest "https://0install.de/files/0install.exe" -OutFile "$env:TEMP\zero-install\0install.exe"
    $env:PATH = "$env:TEMP\zero-install;$env:PATH"
}

if (Test-Path ..\target\docs) {rm -Recurse -Force ..\target\docs}
mkdir ..\target\docs | Out-Null

0install run --batch http://repo.roscidus.com/devel/doxygen

cp CNAME ..\target\docs\

popd
