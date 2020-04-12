import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import matplotlib.axes._axes as Ax
import matplotlib.figure as Fig
import numpy as np
import pandas as pd


def i(*vs):
    for v in vs:
        print(f"{type(v)}\t{str(v)}")


fig: Fig.Figure = plt.figure(figsize=(2, 2))
# fig:Fig.Figure = plt.figure(figsize=(1,1))
ax: Ax.Axes = fig.add_axes([-1, -1, 2, 2])
ax.set_title("title")
ax.set_xlabel("x-label")
ax.set_xlim(left=-1, right=1)
ax.set_ylabel("y-label")
ax.set_ylim(bottom=-1, top=1)
i(ax, ax.title, ax.get_title())
plt.plot()
