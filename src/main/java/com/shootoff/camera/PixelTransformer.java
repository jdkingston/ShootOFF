/*
 * ShootOFF - Software for Laser Dry Fire Training
 * Copyright (C) 2015 phrack
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.shootoff.camera;

import java.awt.image.BufferedImage;

public interface PixelTransformer {
	public void updateFilter(BufferedImage frame, int x, int y);
	public boolean applyFilter(BufferedImage frame, int x, int y, LightingCondition lightCondition);
	public static int calcLums(int rgb) {
		
		//#------------------------------#
		//# For sRGB (and NTSC Rec. 709) #
		//#------------------------------#
		//  Y = 0.2126 Red + 0.7152 Green + 0.0722 Blue
		// http://www.odelama.com/data-analysis/How-to-Compute-RGB-Image-Standard-Deviation-from-Channels-Statistics/
		
		int r = (rgb >> 16) & 0xFF;
		int g = (rgb >> 8) & 0xFF;
		int b = rgb & 0xFF;
		
		/*return (r + r + r +
				b +
				g + g + g + g) >> 3;*/
		return (int)((float)r*.2126 + (float)g*.7152 + (float)b*.0722);
	}
}
