using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dungeons_and_Dragons.Backend
{
    internal abstract class Tile
    {
        Char tile { get; set; }
        int PositionX { get; set; }
        int PositionY { get; set; }
    }
}
