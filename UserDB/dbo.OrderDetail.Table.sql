USE [UserDB]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 2022/4/26 21:23:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[OrderDetailId] [int] NOT NULL,
	[OrderId] [int] NOT NULL,
	[ProductId] [int] NOT NULL,
	[Price] [numeric](18, 2) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Total] [numeric](18, 2) NOT NULL,
	[Fuifilled] [bit] NOT NULL,
 CONSTRAINT [OrderDetail_pk] PRIMARY KEY CLUSTERED 
(
	[OrderDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [OrderDetail_Order_OrderId_fk] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Order] ([OrderId])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [OrderDetail_Order_OrderId_fk]
GO
