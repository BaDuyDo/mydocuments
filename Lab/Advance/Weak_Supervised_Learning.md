- __Weakly Supervised Learning__ 

 Có 3 loại của phương pháp học này:
  * __Incomplete supervision__: When only a subset of training data are labelled, For example: in image categorization the ground-truth labels are given by human annotators; it is easy to get a huge number of images from the Internet, whereas only a small subset of images can be annotated due to the human cost
  * __Inexact supervision__: when the training data are given with labels but not as exact as desidered, i.e. only coarse-grained labels are given. Consider the image categorization task again. It is desirable to have every object in the images annotated; however, usually we only have image-level labels rather than object-level labels. 
  * __Inaccurate supervision__: when in the training data there are some labels with mistakes, i.e. the given labels are not always ground-truth. Such a situation occurs, e.g. when the image annotator is careless or weary, or some images are difficult to categorize.

 1. Incomplete supervision:
  - Thus, the goal of active learning is to minimize the number of queries such that the labeling cost for training a good model can be minimized.Given a small set of labeled data and abundant unlabeled data, active learning attempts to select the most valuable unlabeled instance to query. There are two widely used selection criteria, i.e. *informativeness* and *representativeness* . *Informativeness* measures how well an unlabeled instance helps reduce the uncertainty of a statistical model, whereas *representativeness* measures how well an instance helps represent the structure of input patterns.